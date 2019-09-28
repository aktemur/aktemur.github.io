---
layout: cs392default
---

## Assignment 05

**Persistence for the Faculty Facebook app.**

**Due:** November 24th, Mon. until 23:55.

**Submission:** To LMS.

Previously in [Assignment 3](assignment03.html)
you had extended the [Faculty Facebook app](https://vimeo.com/110571439)
with ability to add new faculty members.
However, your changes were volatile because they were
made to the model objects in the memory.
Now implement methods in the `University`,
`Department`, and `FacultyMember` classes to convert
objects to dictionaries so that they can be saved into
`NSUserDefaults`.
Also implement `init` methods that construct objects
from dictionaries, so that you can build the university
object hierarchy back from the dictionaries you retrieve
from `NSUserDefaults`.

Additionally, extend the app with an "Add new department"
screen, very much like the "Add new member" screen.

Finally, add ability to delete departments and
faculty members when the corresponding table row is swiped.

Below is a suggested representation of Ozyegin University as a
nested combination of dictionaries and arrays.
This can be directly written to `NSUserDefaults`.
Not that we are able to straightforwardly convert a university
to a representation as the one below
because there are no cycles in the containment hierarchy of
`University`, `Department`,
and `FacultyMember` objects.


```python
// Ozyegin University
["departments": [
  // CS Department
  ["fullName": "Computer Science",
   "shortName": "CS",
   "members": [
     ["name": "Reha", "lastName": "C", "userName": "rehac"],
     ["name": "Tanju", "lastName": "E", "userName": "tanjue"],
     ["name": "Baris", "lastName": "Aktemur", "userName": "barisa"]
   ]
  ],
  // EE Department 
  ["fullName" : "Electrical and Electronics Engineering",
   "shortName" : "EE",
   "members" : [
     ["name": "Oguz", "lastName": "S", "userName": "oguzs"],
     ["name": "Murat", "lastName": "U", "userName": "muratu"]
   ]
  ],
  // IE Department 
  ["fullName" : "Industrial Engineering",
   "shortName" : "IE",
   "members" : [
     ["name": "Orsan", "lastName": "O", "userName": "okano"]
   ]
  ]
 ]
]
