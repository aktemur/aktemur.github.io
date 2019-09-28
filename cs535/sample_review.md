---
layout: cs535default
---

From <http://www.cs.uml.edu/~cchen/580-S06/sample_review.html>:

---

[Best-Effort Cache Synchronization with Source Cooperation](http://www.cs.uml.edu/~cchen/580-S06/reading/best-sigmod.pdf)

by Chris Olston and Jennifer Widom

Summary:

This paper presents a push-based method of cache synchronization, where data sources are aware of a cache and actively coordinate in sending updates to the cache.The method prioritizes which data items within a particular source should be sent. This priority is calculated using a previous update times and some weighted divergence metric variables. Once the priority for a certain data item has reached a local source threshold, the source sends the update. Because of unstable system parameters, such as cache and source side bandwidths, this threshold is made adaptive through negative feedback messages from the cache. Each source gradually increases its update threshold. If the cache detects available bandwidth, it will send a message to as many sources as possible, indicating that sources should lower their thresholds.

Comments:

Large scale pushed based systems seem somewhat questionable. It is not very likely that a cache's data sources will decide to coordinate with the cache. Also, assuming the additional complexity (though fairly lightweight) required to be implemented at each source, independent sources will be unlikely to adopt such a scheme.

Although this problem may be orthogonal to the actual efficiency of the paper's algorithm, the authors nonetheless decided to compare it to a pull-based system which is much more likely to be implemented in practice. Pull-based systems will undoubtedly be less efficient and have higher divergence. This is because push-based systems push only changed data, and pull-based systems are expected to obtain at least some unchanged information in predicting which data items might be changed.

However, if a coordinated system of independent data sources and a cache could be developed, the algorithm does seem quite useful. What makes this algorithm attractive is that sources only need to check their data items when the item is updated, and they only need to send updates once the threshold is reached. In addition, the threshold-setting portion of the algorithm ensures that thresholds are kept at reasonable levels. The experimental results are impressive as well, with the actual implemented algorithm performed similarly to an idealized version.

There are some questions, however. The paper claims that an ? = 10 is an optimal value. In addition, the paper states that when available bandwidth is detected by the cache, the cache sends a feedback messages "to as many sources as possible." This would result in 10 times more data coming into the cache. This seems odd, because it implies a considerable amount of bandwidth is unused until the cache sends out a feedback message (the cache must make sure it is safe to receive 10 times as much data). Large amounts of unused bandwidth would make pull-based schemes much more appealing, since pull-based schemes never waste bandwidth. If a push-based scheme wastes more bandwidth (through lack of use) than a pull-based scheme (through obtaining unchanged items) than a pull-based scheme may appear more attractive. A more efficient solution would be to send out messages to selected data sources. Perhaps some other algorithm to determine priority data sources (at the cost of more overhead) would then be required as well.

There are also some implementation questions, such as how to reorder a priority queue as certain data items overtake other items in priority. The question is not so much in reordering as in how this will effect efficiency of keeping track of all data items. Similarly, how a cache could detect violations in a source's updates (perhaps they violate a cache priority policy) might become problematic as well.

In general the algorithm will probably work well when designing a single system with multiple components. It remains to be seen whether independent organizations would be willing to participate in a system that would require more complexity to implement.

