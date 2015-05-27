Mala
=====

[![Join the chat at https://gitter.im/priyatam/mala](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/priyatam/mala?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

![](doc/img/mala-cljs.jpg)

A complete User Interface project template (and refernece app) integrating several Om components, Responsive Design, Router, Event handling and more, with an emphasis on using Clojurescript _all the way_.

## Features

- Sane project structure
- Live, reloadable code with [Figwheel](https://github.com/bhauman/lein-figwheel#writing-reloadable-code)
- Responsive Design with [Garden](https://github.com/noprompt/garden) and [Mesh](https://github.com/facjure/mesh)
- Co-located components and stylesheets
- Routing with Secretary
- Ajax with core.async
- Mock server with real Compojure routes
- Helper utilities
- Curated lein plugins
- Showcase of integrated Examples from select [cljsjs](http://cljsjs.github.io) libraries
- Integrated [Ankha](https://github.com/noprompt/ankha) inspector, [Om-i](https://github.com/PrecursorApp/om-i) instrumentation
- [up](http://swannodette.github.io/2014/12/22/waitin/) to [date](https://github.com/omcljs/om/blob/master/CHANGES.md) dependencies

## Quickstart

    lein new mala chant
    cd chant

The generated src looks like this:

	src
	├── layout
	│   ├── grid.clj
	│   ├── index.clj
	│   └── typography.clj
	└── ui
        ├── client.cljs
		├── components
		    ├── <comp>.cljs
			├── <comp-style>.cljs
		├── router.cljs
		├── state.cljs
		├── types.cljs
		└── utils.cljs
	├── main.cljs
	env
	└── dev
       ├── mock.clj
       └── repl.cljs
	   └── debug.cljs

Start figwheel, watch garden, and a figwheel server integrated with [mock router](https://github.com/priyatam/mala/blob/master/env/dev/mock.clj):

    lein dev

Open `http://localhost:3449/` and look for a Cljs brepl on the prompt.

Ready to deploy? Generate an optimized js file

    lein release

## Documentation

A guide with  workflows and best practices is under [doc](/doc).

## Leiningen Template

A lein-template based on this reference app is under `lein`. Significant changes in the project structure and dependencies will be updated both in the reference app and leiningen template.

For a production-ready Ring server template for building micro-services, see [ring-micro](https://github.com/priyatam/ring-micro).

## Credits

A big thanks to @swannodette for Om, Joel Holbrooks for Garden, and Bhauman for
Fighweel. Some code samples were inspired and copied from:

- [goya](https://github.com/jackschaedler/goya)
- [typeahead](https://github.com/omcljs/om/blob/master/examples/typeahead/src/core.cljs)
- [circleci-frontend](https://github.com/circleci/frontend)
- [om-cookbook](https://github.com/omcljs/om-cookbook)

## Status

[![Clojars Project](http://clojars.org/mala/lein-template/latest-version.svg)](http://clojars.org/mala/lein-template)

- 0.2.x versions included a fullstack template, with Ring/Compojure and uberjar support.
- [0.1.x versions](https://github.com/priyatam/mala/tree/hybrid) included a Less workflow with plain old cljbuld.

## License

Copyright © 2015 Priyatam Mudivarti.

Released under the Eclipse Public License, same as Clojure.
