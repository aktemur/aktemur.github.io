---
layout: cs392default
---

## Lectures

### Week 16
Project presentations.


### Week 15
No lecture due to new year's eve.


### Week 14
Project progress evaluation.


### Week 13
_Topics:_  
Core location, MapKit (*by Gun Makinabakan*)

_Code:_  
[Location Experiment](code/LocationExperiment.zip)


### Week 12
No lecture


### Week 11
_Topics:_  
Animation (*by Gun Makinabakan*)

_Code:_  
[Picnic Animation](code/PicnicAnimation.zip)


### Week 10
_Topics:_  
Closures, Grand Central Dispatch, NSTimer, NSRunLoop, Collections (*by Gun Makinabakan*)

_Tasks:_

+ *Pre-lecture:* Read the [Closures](https://developer.apple.com/library/ios/documentation/swift/conceptual/Swift_Programming_Language/Closures.html) section from the Swift documentation.
+ Exercise: [Exercise 03](exercise03.html).
+ [Assignment 06](assignment06.html)

_Code:_  
[Doviz app with GCD, search, and sort](code/DovizWithGCD.zip)

### Week 9
_Topics:_  
Persistence using NSUserDefaults, Gesture recognizers

_Tasks:_

+ Watch the [Persistence using NSUserDefaults](https://vimeo.com/112039010) video.
+ Watch the [Adding a gesture recognizer to your view](https://vimeo.com/112055449) video.
+ In class: Persistence for the Faculty Facebook app ([Assignment 05](assignment05.html)).

_Code:_  
[UserDefaults Experiment](code/UserDefaultsExperiment.zip)  
[TicTacToe with Swipe Gesture](code/TicTacToeWithSwipeGesture.zip)

### Week 8
_Topics:_  
UICollectionView, JSON, refresh control.

_Tasks:_

+ **Propose your [project](projects.html).**
+ Watch the [Foreign Currency Exchange Rates App](https://vimeo.com/110972729) video.
+ Watch the [Faculty Facebook with Collection View](https://vimeo.com/110975268) video.
+ In class: Start working on [Assignment 04](assignment04.html).

_Code:_  
[Foreign Currency Exchange Rates](code/Doviz.zip)  
[Faculty Facebook with Collection View](code/FacultyFacebookWithCollectionView.zip)


### Week 7
_Topics:_  
Segues, multiple MVCs, navigation.

_Tasks:_

+ Watch the [Intro to Segues video](https://vimeo.com/110560817).
+ Watch the [Faculty Facebook with Navigation video](https://vimeo.com/110571439).
+ In class: An undisclosed assignment, then start working on [Assignment 03](assignment03.html).

_Code:_  
[SegueExperiment](code/SegueExperiment.zip)  
[Faculty Facebook with Navigation](code/FacultyFacebookWithNavigation.zip)  


### Week 6
_No lecture due to Republic's Day._

----
**Note:**  
After upgrading to Xcode 6.1, the code I published
gives compilation errors. (The API is actively 
updated.) Do the following modifications to fix the projects:

_Faculty Facebook with UITableView:_  

*   Change `cell.textLabel!` to `cell.textLabel`. The `textLabel`
    property of `UITableViewCell` is no longer optional.
*   Change the the line that instantiates a `UIImage` and assigns to
    `facultyMemberImage.image`
    to the following:

    ````
    if let nsurl = NSURL(string: url) {
      if let nsdata = NSData(contentsOfURL: nsurl) {
        facultyMemberImage.image = UIImage(data: nsdata)
      }
    }
    ````
    This is needed because
    `NSURL` and `NSData` initializers are now [Failable Initializers](https://developer.apple.com/swift/blog/?id=17).

_Faculty Facebook with UIPickerView:_  
Do the second item above.


----

### Week 5
_Topics:_  
Protocols, delegate, data source, UIPickerView, UIImage from NSURL,
UITableView, reusing table cells

_Tasks:_

+ Watch the [Protocols & UIPickerView video](https://vimeo.com/109308437).
+ Watch the [Faculty Facebook with UIPickerView video](https://vimeo.com/109312665).
+ Watch the [Faculty Facebook with UITableView video](https://vimeo.com/109452842).
+ In class: Remove a faculty member by swiping a table row. Do something cool with UITableView.

_Code:_  
[UIPickerViewExperiment](code/UIPickerViewExperiment.zip)  
[Faculty Facebook with UIPickerView](code/FacultyFacebook.zip)  
[Faculty Facebook with UITableView](code/FacultyFacebookWithTableView.zip)

### Week 4
_Topic:_  
Auto Layout (*by Gun Makinabakan*)

_Tasks:_

+ In class: Fix the GUI problems of [TicTacToe](code/TicTacToe.zip) using auto layout.
+ [Assignment 02](assignment02.html) 

### Week 3
_Topics:_

MVC, Outlet collections, tag property, private functions

_Tasks:_

+ Watch the [TicTacToe video](https://vimeo.com/108132581) 
+ Start working on [Assignment 01](assignment01.html) in class.

_Code:_  
[TicTacToe app](code/TicTacToe.zip)

### Week 2
_Topics:_

+  Garbage collection vs. Reference counting vs. Automatic reference counting
+  MVC 
+  Actions, outlets, random number generation

_Tasks:_

+ Watch the [memory management video](https://vimeo.com/107148799) 
+ Read the [Automatic Reference Counting](https://developer.apple.com/library/ios/documentation/Swift/Conceptual/Swift_Programming_Language/AutomaticReferenceCounting.html#//apple_ref/doc/uid/TP40014097-CH20-XID_88) section of the Swift book.
+ Watch the [MVC video](https://vimeo.com/107611969)
+ Watch the [SimpleDie video](https://vimeo.com/107610781)
+ Watch the [Rookie Mistake video](https://vimeo.com/107789197)
+ Do [Exercise 02](exercise02.html) in class.

_Code:_  
[SimpleDie app](code/SimpleDie.zip)

### Week 1
_Topics:_  
Intro to the Mac environment and the Swift language

_Tasks:_  

+ Watch the [WWDC 2014 video](https://developer.apple.com/videos/wwdc/2014/?id=402) (or try [this link](http://devstreaming.apple.com/videos/wwdc/2014/402xxgg8o88ulsr/402/402_sd_introduction_to_swift.mov?dl=1))
+ Read [A Swift Tour](https://developer.apple.com/library/prerelease/mac/documentation/Swift/Conceptual/Swift_Programming_Language/GuidedTour.html#//apple_ref/doc/uid/TP40014097-CH2-XID_1) in [The Swift Programming Language](https://developer.apple.com/library/prerelease/ios/documentation/Swift/Conceptual/Swift_Programming_Language/) documentation.
+ Watch the [Swift Playgrounds video](https://developer.apple.com/videos/wwdc/2014/?id=408) until the XCPlayground section (or try [this](http://devstreaming.apple.com/videos/wwdc/2014/408xxcm26svis12/408/408_sd_swift_playgrounds.mov?dl=1) link)
+ Do [Exercise 01](exercise01.html) in class.
+ Be aware of the [Resources page](https://developer.apple.com/swift/resources) of the [Swift site](https://developer.apple.com/swift/).

<!--
### Upcoming

+  Custom views, NSTimer (via Bouncing Ball app)
+  UIAnimation
+  MapKit
+  Media (image, movie, audio)
+  Core Location
-->
