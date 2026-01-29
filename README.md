# Lab01-USACO

Test cases are stored in `makelake.x.in` and `ctravel.x.in` and correct results are stored in `makelake.x.out` and `ctravel.x.out` 

In the file names: x is the test case number. Test cases 0,1,2,and 3 are provided in the repo. The answers are in the corresponding output files.

# Testing of USACO.java

Note that test 1 for both problems match the test cases given in the problem descriptions. 

```java 
    long ans = Bronze.solve("makelake.1.in");
    System.out.println(ans);
    long ans2 = Silver.solve("ctravel.1.in");
    System.out.println(ans2);
```
# Sample usage of driver

A driver is given that matches how I will test your code. 

To test `ctravel.1.in` using the driver use the command:
`java Driver 1 silver`

To test `makelake.1.in` using the driver use the command:
`java Driver 1 bronze`
