# Web support for YAML via Jackson

1. `application/yaml`, `application/yml` mediatypes are not suggested by completion in 
   `@RequestMapping` #produces and #consumes attributes
   https://youtrack.jetbrains.com/issue/IDEA-358655
2. HTTP Client generating doesn't support this mediatype
   https://youtrack.jetbrains.com/issue/IDEA-358656


Mediatypes in @ExceptionHandler:
https://youtrack.jetbrains.com/issue/IDEA-358667