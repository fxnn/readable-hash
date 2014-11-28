Readable Hash
=============

Implements a hash function that computes human-readable output. Built with plain Java and Maven.

The computed values are strings alternating between consonants and vowels. One possible usecase is the pseudonymization of data.

Example outputs of the current implementation are `Mezimjhjbu`, `Xabjfo` or `La`.

[![Build Status](https://travis-ci.org/fxnn/readable-hash.svg?branch=master)](https://travis-ci.org/fxnn/readable-hash)


Usage
-----

Either use the provided [static void main](src/main/java/de/fxnn/readablehash/ReadableHashCliApplication.java), or use the [ReadableHash-class](src/main/java/de/fxnn/readablehash/ReadableHash.java):

```java
ReadableHash readableHash = new ReadableHash();

String myHash = readableHash.hashAsReadableString("Hello, World!");
assertEquals("Cjtaqafeyu", myHash);

String myOtherHash = readableHash.toReadableString(1234L);
assertEquals("Subise", myOtherHash);
```


Related Work
------------

* [humanhash](https://github.com/zacharyvoase/humanhash) by zacharyvoase is a Python program that turns digests into a series of words from the english language, so that it can be "shouted down a hallway".


License (MIT)
-------------

Copyright 2014 Felix Neumann (http://fxnn.de)

This project is free software released under the MIT/X11 license:

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
