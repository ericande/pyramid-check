This project was designed to be a sample Jersey REST api, run on Tomcat 9.0.26.

The api is set up to respond to GET requests to /webapi/pyramid/{word}, and responds
with a boolean value indicating whether the input word was a pyramid word.  A pyramid
word is defined here as a string where the least common character occurs once, the
second least common occurs twice, and the nth least common occurs n times.  Inputs are
converted to lower case but otherwise all input characters are counted. For example:

banana: true
a: true
eevee: false
barb: false