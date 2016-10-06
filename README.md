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