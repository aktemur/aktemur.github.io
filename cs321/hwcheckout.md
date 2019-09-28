---
layout: cs321default
---

## How to check out HW files
Check out the exercise files from the SVN repository. 
To do this, run the following command in your terminal,
but replace each occurrence of `donald.duck`
with your username, and `hw1` with the actual hw name. 

```
svn co --username donald.duck https://srl.ozyegin.edu.tr/cs321students/donald.duck/hw1
```

Now, change your directory to `hw1` and there you have all the files you need.

### Submission
To submit, run the following command while your are inside the
`hw1` directory:

```
make commit
```

You may submit as many times as you want.
