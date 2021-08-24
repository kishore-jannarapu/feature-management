# Feature Management Service

## Get access by email and feature

Get the user access for a feature by email and feature name.
Returns the access for the feature.

```
curl -X GET \ 'http://localhost:8081/feature?email=user1%40email.com&featureName=feature1'
```

## Update the feature

Update the feature by email and feature name, returns the status code 304 if the resource is not modified and returns 200 if the resource is updated successfully.

```
curl -X POST \
  http://localhost:8081/feature \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
        "email":"user1@email.com",
        "featureName":"feature1",
        "enable":false
    }'
```
