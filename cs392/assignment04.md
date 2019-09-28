---
layout: cs392default
---

## Assignment 04

**Due:** November 19th, Wed. until 14:00

**Submission:** Show your code to Buse Yilmaz.

See [this video](https://vimeo.com/111294057) for the assignment.

#### Hints
Rather than starting to work with an already-configured
collection view controller, 
drag out a search bar and a collection view on to generic view.
Then make the delegate & datasource connections,
and implement the corresponding protocol methods.

You may find the `searchBarSearchButtonClicked`
method useful.

As my model, I defined a field, named `entries`.
It is an array of dictionaries with this type: `[[String: AnyObject]]`.
I cast `AnyObject` to an appropriate type (e.g. a `String` or `[String: String]`)
according to the context.
