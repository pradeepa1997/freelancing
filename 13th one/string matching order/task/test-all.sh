# Devon Gadarowski 2019

testcases=(
	"Halim"
	"A"
	"Lateralus"
	"TheGlobalist"
	"Explorers"
	"DreamersBall"
	"Bogus"
)

num_pass=0
num_cases=0

#check to make sure all required files are present
for testcase in ${testcases[@]};
do
	if [ ! -f $testcase.java ]; then
		echo "You need to copy all of the test cases to this folder before running!"
		echo "Missing: $testcase.java"
		exit
	fi

	if [ ! -f sample_output/$testcase.txt ]; then
		echo "You need to copy the sample_output folder and its contents to this folder before running!"
		echo "Missing: sample_output/$testcase.txt"
		exit
	fi
done

# print header
printf "\n%17s%28s\n" "TestCase" "Result"

echo "===================================================="

for testcase in ${testcases[@]};
do
	printf %-34s $testcase.java
	((num_cases++))

	rm -f *.class
	rm -f output.txt

	# Check if the test case compiles
	javac $testcase.java 2> /dev/null
	compile_value=$?
	if [ $compile_value != 0 ]; then
		echo "Failed to Compile!"
		continue
	fi

	rm -f *.class

	# Check if the test case throws warning messages
	javac -Werror $testcase.java -Xlint:unchecked 2> /dev/null
	compile_value=$?
	if [ $compile_value != 0 ]; then
		echo "Compiled with warnings!"
		continue
	fi

	# Check if the test case crashes
	java $testcase > output.txt 2> /dev/null
	runtime_value=$?
	if [ $runtime_value == 124 ]; then
		echo "Timeout"
		continue
	elif [ $runtime_value != 0 ]; then
		echo "Crashed!"
		continue
	fi

	# Check if the output is correct
	diff output.txt sample_output/$testcase.txt > /dev/null 2> /dev/null
	diff_value=$?
	if [ $diff_value != 0 ]; then
		echo "Wrong Answer!"
		continue
	fi

	echo "PASS"
	((num_pass++))
done

echo "===================================================="
echo

rm -f *.class
rm -f output.txt

if [ $num_pass == $num_cases ]; then
	echo "               H A P P Y     T U R K E Y     D A Y"
	echo ""
	echo "                                       ____"
	echo "                                      :    :"
	echo "                  ___                 :____:"
	echo "          ___ ---\ ~~ /---___         :  []:"
	echo "          \   \ ~ \~ /~~~/~~~/     ----,-------"
	echo "        ,' \~~ \~~ \/ ~~/~~~/ \`,     ,'  0 0 __"
	echo "       -_~~ \   \,------,  / ~ _\`    ;    _____\\"
	echo "      ;   - _ \,'^^^^^^^ \"\"\`,_-  \   \`, \`--'; u"
	echo "      ; ~~   ,'^^^^-----------   /   ,'\`,,,'"
	echo "      ;~ ---, ^^^,\`__----,  ..\`,/  ,'..,'"
	echo "      \`,  ~ ,^^ <_'__--__ \`, .. \`,/ .. \`"
	echo "       \`,---\` ^<________--  \`, .. ..  ,'     ___ [] ___"
	echo "        \`,---\` <__ -__ ___  ,' .. . ,\`     _/   \)(/   \_"
	echo "         \`, --\` <__ __ _  ,' ... _,\`      /   /      \   \\"
	echo "          \`--,___<___   ,'\`-___,'       ,'   :   |        \`,"
	echo "                  <___,'(||)            :             :    :"
	echo "                    ||   ||             :    :   |         ;"
	echo "                  __||_ _||_            \_            :   _/"
	echo "                 // ;;\\\\ ;;\\\\             \_  \  |   /  _/"
	echo "                ~~     ~~   ~~              \__________/"
	echo
fi

echo "Make sure you are using the Rabin-Karp Substring"
echo "Search Technique for this assignment. Brute-Force"
echo "approaches will not receive full credit."


