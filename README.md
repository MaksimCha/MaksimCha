# Second Homework:

Use webTests.xml or nativeTests.xml to run web or native tests respectively.

1.
> Rewrite Driver using “singleton” pattern. Are there any advantages?

Done but with lazy initialization, because type of driver depends on properties

2. 
> Suggest improvements for .properties reading. What are the purposes?

- Property files are used to easy change capabilities for different devices.
- Split properties depends of tests type: web or native.
- Using enum PropertyFIle for different values of properties path.

3. 
> Add checks of other fields and their titles (Contact Name, Contact phone) in “native” test

Add checks for "Target Account", "Contact Name", "Contact Phone" titles and fields.

4.
> **Optional**: Add keyboard presence check  in “native” test.

Using try - catch block to know keyboard status, but not sure that it is correct way.

5. 
> Which checks would you place in the “web” test?

Add check title, url.

6. 
> Implement checks for “web” test in code and try to use.

Done in "WebTests.java".
