/**
 * 
 */
const empty = {}; // An object with no properties
const point = { x: 10, y: 50 }; // Two properties
console.log(point.x);
console.log(point.y);
const point2 = { x: point.x, y: point.y + 1 }; // More complex values
console.log(point2.x);
console.log(point2.y);
const book = {
	language: "English",
	'main title': 'JavaScript', // Property names include spaces,
	'sub-title': 'The Definitive Guide', // and hyphens, so use string literals
	'for': 'all audiences', // for is a reserved word, so quote
	author: { // The value of this property is
		'firstname': 'Donald', // itself an object. Note that
		surname: 'Duck' // these property names are unquoted.
	}
};
console.log(book);
console.log(book['main title']);
console.log(book['sub-title']);
console.log(book['for']);
console.log(book.author['firstname']);
console.log(book.author['surname']);
// console.log(book.sub-title);
console.log(book.for);
console.log(empty);

const o = new Object(); // Create an empty object: same as {}.
console.log(o);
const a = new Array(); // Create an empty array: same as [].
const d = new Date(); // Create a Date object representing the current time
const r = new RegExp('js'); // Create a RegExp object for pattern matching.

const f1 = function () {
  document.writeln('The Cow Jumped over the MOON');
};

const o1 = Object.create({ x: 100, y: 200 });
console.log('x= ' + o1.x + ' y=' + o1.y);

const o2 = Object.create(null); // Doesn't have a parent.
const o3 = Object.create(Object.prototype); // o3 is like {} or new Object().
console.log(o2);
console.log(o3);

const o4 = { x: "don't change this value" };
 console.log(o4.x);
o4.x = 'Deepa';
console.log(o4.x);

  