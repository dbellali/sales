### Evaluation Guide:

What we are looking for
You will be evaluated on how you reach the solution, keeping in mind that the correctness of the solution
will also be taken into consideration. Your focus should be on these elements of code quality:
• Code easy to read and to maintain (i.e. Clean code)
• Object-oriented design
• Unit testing
• Expandable design
• SOLID principles
What you should aim to deliver

A simple web service or console application does the job. You do not need to implement any input mecha-
nism, any UI nor data store. It is important to keep in mind that we are looking for code quality and attention

to details, not quantity of code.
There is no constraint in Input and Output design as long as it’s provide the requested information. You may
use frameworks and/or tools that are in general usage for the target technology stack (for example your
preferred unit testing framework).
However, the central problem of the coding exercise should be performed entirely by your own code.
Please note that, according to the information collected from the candidates, they usually spend between 4
to 12 hours on this coding exercise.

• The code must be written using an IDE like Eclipse or Intellij, two free IDE available on the internet.
• Once the code is written, the source code must be submitted without its byte code; please remove any
files archiving byte code (jar, war, ”*.class” and the bin/target directory).
• The code can be submitted using an archive file or a link to a git repository.

### Problem: Sales Taxes

Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that
are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no
exemptions.
When I purchase items, I receive a receipt which lists the name of all the items and their price (including tax),
finishing with the total cost of the items, and the total amounts of sales taxes paid. The rounding rules for
sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05)
amount of sales tax.
Write an application that returns the receipt details for these shopping baskets...

INPUT

Input 1
```bash
1 book a t 12.49
1 music CD a t 14.99
1 choco la te bar a t 0.85
```

Input 2
```bash
1 imported box o f choco la tes a t 10.00
1 imported b o t t l e o f perfume a t 47.50
```

Input 3
```bash
1 imported b o t t l e o f perfume a t 27.99
1 b o t t l e o f perfume a t 18.99
1 packet o f headache p i l l s a t 9.75
1 box o f imported choco la tes a t 11.25
```

OUTPUT

Output 1
```bash
1 book : 12.49
1 music CD: 16.49
1 choco la te bar : 0.85
Sa les Taxes : 1.50 To ta l : 29.83
```

Output 2
```bash
1 imported box o f choco la tes : 10.50
1 imported b o t t l e o f perfume : 54.65
Sa les Taxes : 7.65 To ta l : 65.15
```

Output 3
```bash
1 imported b o t t l e o f perfume : 32.19
1 b o t t l e o f perfume : 20.89
1 packet o f headache p i l l s : 9.75
1 imported box o f choco la tes : 11.85
```