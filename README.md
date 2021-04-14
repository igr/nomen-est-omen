# Nomen est Omen

![](https://img.shields.io/maven-central/v/com.oblac/nomen-est-omen.svg)

_"Your name is your destiny"_, so be sure you pick a good name.
This Java library helps with generating some super-awesome random names
that you can use for some unique IDs :)

Generated names may consist of:

+ adjective (1400+)
+ animals (380+)
+ color name (80+)
+ nouns (850+)
+ person name (140+ names)
+ superb name (10+ names)
+ pokemon name (700+ names)
+ superheroes name (1800+ names)
+ count (any number > 0)

For example, you can get names such: `hungry_navy_babbage`
or `dreamy-cray`. Isn't this super great?

## Usage

It's complicated.

### 1. Add dependencies

In your Gradle or Maven project, add:

    com.oblac:nomen-est-omen:<version>

### 2. Use it

If you just want a short name (adjective and person name):

	Nomen.randomName();

If you want to build your own template, e.g.:

	Nomen.est().adjective().color().person().get();

Variables are set using `withXxx()` methods:

	Nomen.est().adjective().color().person().withSpace('/').get();
	
That is all.

### 3. Optimise if you will

Templates can be created once:

	Nomen uigen = Nomen.est().adjective().person();
	...
	String id1 = uigen.get();
	String id2 = uigen.get();

Nice!

## Thanx to Docker

I am blatantly stealing idea from [Docker](https://github.com/docker/docker/blob/master/pkg/namesgenerator/names-generator.go).
It is so beautiful, that it deserves Java port :)


## License

[BSD](LICENSE)