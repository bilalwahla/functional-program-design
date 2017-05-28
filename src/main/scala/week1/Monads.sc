/*
for expressions are useful not only for collections. Many other types also define map,
flatMap and withFilter operations and with them for expressions.

Examples: Generators, Option, Try

Many of the types defining flatMap are Monads. If they also define withFilter, they are
called "monads with zero". The three monad laws give useful guidance in the design of
library APIs.
 */