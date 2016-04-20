# Nomen est Omen

_"Your name is your destiny"_, so be sure you pick a good name.
This Java library helps with generating some super-awesome names :)

Generated names, at this moment, may consist of:

+ adjective
+ color name
+ person name

For example, you can get names such: `hungry_navy_babbage`
or `dreamy_cray`. Isn't this super great?

## Usage

It's complicated.

### 1. Add dependencies

In your Gradle or Maven project, add:

    com.oblac:nomen-est-omen:1.1

### 2. Use it in Java

If you just want a short name (adjective and person name):

	Nomen.randomName();

If you want to build your own template, e.g.:

	Nomen.est().adjective().color().person().get();

That is it.

## Thanx to Docker

I am blatantly stealing idea from [Docker](https://github.com/docker/docker/blob/master/pkg/namesgenerator/names-generator.go).
It is so beautiful, that it deserves Java port :)


## License

[BSD](LICENSE)