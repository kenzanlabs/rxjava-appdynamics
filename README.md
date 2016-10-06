## RxJava-AppDynamics


# Overview
rxjava-appdynamics provides specific hooks for Appdynamics to instrument rxjava streams

**Latest Release: 0.0.1**

# Usage
Using RxJava-AppDynamics is a two-step process:

1. Incorporate Library
2. Register the Hook

## Incorporate Library

### Maven

```
<dependency>    
    <groupId>net.kenzan.rxjava</groupId>
    <artifactId>rxjava-appdynamics</artifactId>
    <version>0.0.1</version>
</dependency> 
```

## Register Hook
You must register the hook in one of the following two ways.

### System Property
Set the following System Property:

```
rxjava.plugin.RxJavaObservableExecutionHook.implementation=com.kenzan.rxjava.appdynamics.hook.ObservableExecutionHook
```

### Guice
Add the RxJavaAppDynamicsModule to your bootstrap.

```    
	@Override
	protected void configureBootstrapBinder(BootstrapBinder binder) {
		...
		
		binder.install(new RxJavaAppDynamicsModule());
		
		...	
	}
```

# Dependencies
| GroupId   | ArtifactId    | Min. Version |
| --------- |:-------------:| ------------:|
| io.reactivex |  rxjava   |  1.1.1  |

# Hooks for Appdynamics
- onCreate: via AppdOnSubscribe
- onSubscribeStart: via AppdOnSubscribe
- onLift: via AppdOperator
- onSubscribeReturn: via AppdSubscription

# Wiki
Wiki for this library for in-depth information: [Wiki](https://github.com/kenzanmedia/rxjava-appdynamics/wiki)

# License
Copyright © 2016 Kenzan, LLC (http://kenzan.com)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.