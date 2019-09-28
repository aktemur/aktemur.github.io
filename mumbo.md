---
layout: default
---

## Mumbo
Mumbo is an object oriented language supporting run-time program generation.
It is a simplified model of [Jumbo](http://loome.cs.uiuc.edu/Jumbo/).
Mumbo is implemented using [Maude 2.1](http://maude.cs.uiuc.edu/).
It can be compiled to _LowLevel_ code,
which is a 3-address language implemented again using Maude.
You can find all the necessary files in this [zip bundle](../data/mumbo.zip).

### Running
```
Maude> in mumbo.maude
```

will load the main file,
which automatically loads other necessary files,
like syntax,semantics and preprocessing stage.

```
Maude> in mumbo-optimization.maude
```

will load the files and the modules necessary to use the interactive loop.

```
Maude> in mumbo-examples.maude
```

contains some examples that illustrate how to use the interactive loop to optimize code generators.

```
Maude> in lowlevel.maude
```

will load the files necessary to use the lowlevel language.

```
Maude> in lowlevel-examples.maude
```

will run some Mumbo examples which were compiled to lowlevel.

### File list
The following is the list of files contained in the source bundle.

Mumbo files:

* mumbo.maude
* mumbo-syntax.maude
* mumbo-preprocess.maude
* mumbo-semantics.maude
* mumbo-compiler.maude
* mumbo-optimization.maude
* mumbo-analyses.maude
* mumbo-transformations.maude
* mumbo-examples.maude

LowLevel Files:

* lowlevel.maude (includes syntax and semantics)
* lowlevel-compiler.maude
* lowlevel-examples.maude
