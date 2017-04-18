# ppl-assignment-shaken-notstirred
ppl-assignment-shaken-notstirred created by GitHub Classroom

PPL Assignment of Pranjal Sanjanwala (IIT2015088) | 
Phase-1 in master branch | 
Phase-2 in 'Q3-Q10' branch |
Phase-3 in 'Q11' branch
**************************************************************************************************
THE PROJECT HAS BEEN CREATED IN NETBEANS 8.2 (Windows 10 64 bit).CONSIDER BUILDING IT ACCORDINGLY
**************************************************************************************************
COMMON DETAILS :
-> INPUT FILES : 'boy.txt','girl.txt','gift.txt'
->OUTPUT FILES : Mentioned below,question wise.

NOTE : No changes have been made to the constraints of questions unless specified below.
**************************************************************************************************
Q1:
the given program takes input from two files namely girl.txt & boy.txt.

both files begin with an integer valur which denotes the no. of boys or girls whose attributes have been specified in the remaining file.

having stored the obtained attributes in the respective classes , namely girl & boy , the code begins match making

matches are made according to the order of inuput & following the primary 2 conditions.
1. maintenence budget of girl should be lesser than the budget of the boy
2. the minimum requirement of attractiveness of boy should be less than the attractiveness of the girl. 

As mentioned in the question, only the order of input is considered.the match making doesn't adhere to the girl's criterions of Most Rich,Most intelligent,etc.
Those criterions will be taken care of in the later installments of the assignment.
********************************************************************************
Q2 :

The given code takes a text file couple.txt as input and does gifting.

the text file couple.txt includes all attributes of the boy as well as the girl who both are committed to each other.

As an output, a file will be generated which will print the happiest and the most compatible couples in decreasing order of their happiness & compatibility respecively.

*********************************************************************************
Q3:

The Q no. 2 is implemented using inheritance.The structure can be seen in the attached class diagram.Output of the code is stored in the file couple.txt(UTf-8 format).

**************************************
Q4:

A breakup is performed for the k least happy couples and matching is performed again.The value of k is assigned in line : 29 of the main class called 'Q4'.The revised matches made are stored in the file newcouple.txt (UTF-8 format).

**************************************
Q5:

There are two choices in Algorithms.The choice integer variable in line 37 of the main class 'Q5' can be assigned value 1 or 2 accordingly.The matches are made in an alternate fashion i.e. the girl is allowed to choose once and then the boya and so forth.The matches so made are stored in a file 'alternateCouple.txt' (UTF-8 format)

**************************************
Q6:

The algorithm for breaking up pairs and reforming them has been implemented taking into account the constraint of happiness.An output file 'couple.txt' has been generated in the end which enlists the intact couples in the end.

**************************************
Q7:

There are three choices in method to find the girlfriend of a given boy.A file called 'boy.txt' gives us a list of boys whose girlfriends have to be found.A variable 'ans' has to be assigned a suitable value according to the prefered method.The matches found are stored in a file 'foundCouple.txt' (UTF-8 format)

**************************************
Q8:

Allocation of gifts has to be done.There are two choices for algorithm to be implemented.To choose an algorithm the selection_flag variable has to be set on line 105 of class 'Q8'.Based on the chosen algorithm the gifts are allocated based on which the k happiest couples and k most compatible couples are printed in a file 'answer.txt'(UTF-8 format)

***************************************
Q9:

Match-making and Allocation of gifts is done between top k of the given entities in this Question.The answer is stored in a file 'couple.txt'(UTF-8 format).A template class is made that is generic and that returns top k values irrespective of the type of object.The answer is stored in a file 'answer.txt'(UTF-8 format)

***************************************
Q10:

Match-making and Allocation of gifts is done between top k of the given entities in this Question.The answer is stored in a file 'couple.txt'(UTF-8 format).A template class is made that is generic and that returns k random values irrespective of the type of object.The answer is stored in a file 'answer.txt'(UTF-8 format)
***************************************
PHASE-3

The codes of all previous Qs have been modified to handle Exception Handling.

Q1-Q2 are not uploaded again because each of them constitute of a basic algorithm which has been used a number of times in the questions further in which Exceptions have been handled prperly.

Following Exceptions can be handled in every code.

-> File Not Found Exception
-> Array Index Out Of Bounds Exception
-> Arithematic Exception
-> Null Pointer Exception
-> Number Format Exception

The projects have been made in a way that any one of all possible Exceptions is triggered and the corresponding notification is printed on the console.

Q3:

File 'gift.txt' is missing.So, a file not found exception is encountered.

Q4:

Array index one more than the size of array is refered to on line 43 in the main class.So, an Array Index Out Of Bounds Exception is encountered.


Q5:

A number is being divided by 0 on line 119 in the main class.So, an Arithematic Exception is encoutered.

Q6:

A typo in file name has led to a File Not Found Exception.The project expects a file called 'girl.txt' instead of which the file name in the concerned location is 'girll.txt'.

Q7:

Due to a change in loop upper bound, an input of type String is being given to the variable of type int.This is causing a Number Format Exception.

Q8:

Array index one & 2 more than the size of array is refered to on line 75 in the main class.So, an Array Index Out Of Bounds Exception is encountered.

Q9:

A variable in the termination condition of loop on line 39 is being divided by 0.So, an Arithematic Exception is encountered.

Q10:

File 'boy.txt' is not found at its place.So, a File Not Found Exception is encountered.



