# JaCoCo-PowerMock-Error

Project to identify error on integration with JaCoCo and PowerMock

Status:

On branch master uses java11 with online instrumentation. The code coverage on DummyService is 15%

On branch java8 uses java8 with offline instrumentation. The code coverage on DummyService is 100%

On branch java11 uses java11 with offline instrumentation. The tests are broken with the error bellow:

```
[ERROR] Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.368 s <<< FAILURE! - in br.com.testing.jacocoerror.service.DummyServiceTest
[ERROR] initializationError(br.com.testing.jacocoerror.service.DummyServiceTest)  Time elapsed: 0.01 s  <<< ERROR!
java.lang.IllegalStateException: Failed to transform class with name br.com.testing.jacocoerror.service.DummyServiceTest. Reason: java.io.IOException: invalid constant type: 17 at 49
Caused by: java.lang.RuntimeException: java.io.IOException: invalid constant type: 17 at 49
Caused by: java.io.IOException: invalid constant type: 17 at 49
```
