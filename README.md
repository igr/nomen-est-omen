# Nomen est Omen

_"Your name is your destiny"_, so be sure you pick a good name.
This Java library may help you with generating awesome name.

The generated name consist of:

+ adjective
+ (optional) color name
+ person name

For example, you can get names such: `hungry_navy_babbage`
or `dreamy_cray`. Isn't this super great?

## Usage

It's complicated.

### 1. Add dependencies

In your Gradle or Maven project, add:

    com.oblac:nomen-est-omen:1.0

### 2. Use it in Java

If you want a short name (just adjective and person name):

	Nomen.randomShortName();

If you want a longer name:

	Nomen.randomName();

That is it.

## Thanx to Docker

I am blatantly stealing idea from [Docker](https://github.com/docker/docker/blob/master/pkg/namesgenerator/names-generator.go).
It is so beautiful, that it deserves Java port :)


## License

BSD