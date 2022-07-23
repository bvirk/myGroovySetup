## [Groovy](https://en.wikipedia.org/wiki/Apache_Groovy)

... makes java more tolerable, with the boilerplate element toned down and a number of convenient features added.

The following is a setup to compile groovy for programs.

### Characteristics of the setup

- same directory tree for all programs
- same build.xml for all programs
- a program is called using a, located in PATH, with a directory specified in the deploypath property in build.xml, symbolic link
- same wrapper calls all programs

### Prerequisites

java 8, ant, groovy and environment variables JAVA_HOME, ANT_HOME and GROOVY_HOME  set

```
\$ groovy version
Groovy Version: 4.0.2 JVM: 1.8.0_202 Vendor: Oracle Corporation OS: Linux
\$ ant version
Apache Ant(TM) version 1.10.12 compiled on June 4 2022
```

### Install and configure

- git clone https://github.com/bvirk/myGroovySetup
- rename to something of your choice - in the following called groovy 
- correct deploy property in build.xml to one in PATH listed in dir with write rights for user
- fix src/utils/cg/utils/MachineSetting.groovy if the program 'japi' shall work

### new program
Don't bother making the initial source file - just do:

```
groovy$ ./gr-compile myApp
...
groovy$ \$EDITOR src/myApp/cg/myApp.groovy
```
And along the way
```
groovy$ ./gr-compile myApp
```
or
```
groovy$ ./gr-run myApp [args ...]
```
The finished program
```
$ myApp [args ...]
```

### japi
direct MachineSetting.groovy to those of the computer's jar files for which api to classes documentation is desired.

Then try with class List

```
groovy$ ./gr-run japi List
```

hereafter simply

```
$ japi MyClass

```

### Remove program

```
groovy$ ./gr-clean myApp
```

The source code is not removed.
 
