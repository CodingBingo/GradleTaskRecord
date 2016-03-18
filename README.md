# GradleTaskRecord
----
This is a plugin for gradle user who want to have a clearly look on the time spend in every task.

![Alt Text](https://github.com/CodingBingo/gradletaskrecord/raw/master/img/result.png)


# Usage
If you want to use this.

1、With Gradle
```gradle
  buildscript {
      repositories {
          jcenter()
          maven(){
              url 'https://dl.bintray.com/codingbingo/maven'
          }
      }
      dependencies {
          classpath 'com.codingbingo.library:gradletaskrecord:1.0.0'
          // NOTE: Do not place your application dependencies here; they belong
          // in the individual module build.gradle files
      }
  }

  apply plugin: 'com.codingbingo.gradletaskrecord'
```

---
# License
```license
    Copyright 2013 Square, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
```
