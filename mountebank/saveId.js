function(config) {
    var response = {
                    "statusCode": 200,
                    "headers": {
                      "Content-Type": "text/html; charset=utf-8",
                      "Cache-Control": "no-cache, no-store, max-age=0, must-revalidate",
                      "Pragma": "no-cache",
                      "Expires": "Mon, 01 Jan 1990 00:00:00 GMT",
                      "Date": "Sun, 06 Oct 2019 14:51:49 GMT",
                      "Content-Language": "en-US",
                      "Content-Security-Policy": "script-src 'report-sample' 'nonce-+fsZyv2/BnSQ6cclWCn4Cg' 'unsafe-inline' 'strict-dynamic' https: http: 'unsafe-eval';object-src 'none';base-uri 'self';report-uri /o/cspreport",
                      "Content-Encoding": "gzip",
                      "Server": "ESF",
                      "X-XSS-Protection": "0",
                      "X-Frame-Options": "SAMEORIGIN",
                      "Alt-Svc": "quic=\":443\"; ma=2592000; v=\"46,43\",h3-Q048=\":443\"; ma=2592000,h3-Q046=\":443\"; ma=2592000,h3-Q043=\":443\"; ma=2592000",
                      "Transfer-Encoding": "chunked",
                      "Connection": "close"
                    },
                    "body": "H4sIAAAAAAAC/4RV+2/iOBD+vX9FirQCdARCChS2hBPPvm67W8qrqFJlnCFxSeyc7QToqv/72eFxrPZONRLY45lvZr4ZD83z3vfu6PlH3/BlGLSa+29AbqspiQygNWB8jbhLqGcUi8VmaSdthiCRspGRCX/HJHEymFEJVJpyG0HG2J+cjISNLGnUKwP7iAuQTiyXZj3zHxAzc9w2uyyMkCSL4BTltu+A68HBiKIQnExCYB0xLk/01sSVvuNCQjCY6aFgEEokQYEpMArAKReMUEnCODwRoM2vglgAT09IheFYyq3AnETSEBw7WR2y+FoqCREUPSFVsLiIWVhCGLOYSlFipXq9YZdtq9YwN4IvtQ6EiCIPePFNZA3KKFYJ/LEU821ilzr06bGGcTDt0krXU95KO3dqs6vEgrlbo9Wk7CD/jToOSw7CP6HCuop54KhYDlYa94hw1jw3TWPJFZGLWEjgytAFQ0XKpTB84GCYptISchvAZ/FGASJUF/qnS4Q6bL8qA/hQaWhrjbJj7xOYs9wyplgSRnP5n2eSb3+eGWoliBtrQh3pE3GVStY+CSCXaR79tjL5na5aZJlT2sUIcU2Do/b5w5VaCw5odXUQQIKCXEarp0z0AwiVUVFVOZMvinghJM9ZhXL+aKDj+Bd9J/44O3F7inPu0DgI8tLnbG1kU5rd7M7GZThOXa05kSqVl81FdxNGRkqYOvROiVTnfkbF8IGRxH4O9rkeCdq7P2cR0FzAlJaisJB9lSzK5k+TN1R7c5nLaiYPjWJgpL4WsOsFN7vLVZkWD0jOYbNP9xjFx5n65HPK4tiwu7ZymSq1NDiELAFD+mAcK6UuuKEzlcgTuxY73pVaTXXTUjNG//xPhwJ1f+nPXWfpobOfNW8oQfuG/6zhfnub2GdMwD1s29Qdgks4YJkz9g/+pfRyfOJFjzEvAP3sX0qCeJTQlxJDsfT/xAFRtL4SV5XNta1KtVar25ZdqZm1S6nmymXFk8llPSZIrMJGpQqUVhdV5AV2EUXRAVlPoH2FUicbu4aERvTAvni6EbW5uR7PKjN4Y7fTyaO+d0FIQtNKaUUddBqzZDFnS0UZA3HEiiLOVPO/pulr9fOuP7SeaDSa9gZvo/f+FvUG1ceZiybjyfXIv10+9ILywtoEi7Avn60AudZKfrOD6bdxY4Sm89snOrmbju7Y9PFL3/5Sr39pNNp3Pd6o19t6zeZy2MEI9ZY3VcGG1fB9bL1OfUxX89f+4Haio0oJ9NyI64DKWpJWiHj63PVXbWj79VG9/Ly1HpLGtMo694P7IQfvre19c6U76HtVH990touLub8YNN7d64E1H97+Nb+eqH0QP8+G0cKuPHVmD8nz9KHc9xrJ82xioZu7CNuyiu2HBF+PswUji1fvD5fROOJRYsez9x+4F36f9nzoWp275IJ3bKQYXODO04++Vv/ebd9nC5LHUPi0X9iLmsOYsRUB9dxOhr0e83rm6//gfwAAAP//AwAu5zN5mQcAAA==",
                    "_mode": "binary",
                    "_proxyResponseTime": 116
                  };
    config.logger.info('Saving id');
    var redirect_uri = config.request.query['redirect_uri'];
    var id = redirect_uri.substring(redirect_uri.indexOf('=') + 1);
    config.logger.info(JSON.stringify(id, null, 4));
    config.state.id = id;
    config.logger.info('State: ' + JSON.stringify(config.state, null, 4));
    return response;
}