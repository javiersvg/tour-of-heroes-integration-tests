###Mock google sign in:

# Set hosts
```127.0.0.1          accounts.google.com```

# Install mountebank
```npm install -g mountebank```

# start mountebank
```mb start```

# Post imposter with postman
```POST: localhost:2525/imposters``` with ```postmanbody.json```

# Install locally trusted certs
