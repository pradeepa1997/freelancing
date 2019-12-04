# Devon Gadarowski 2019

testcases=(
	"FiveOverSeven"
	"SixOverSix"
	"TwoOverThree"
	"OneOverTwelve"
	"ThirtyOneOverThirty"
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
	((num_cases++))
	printf %-34s $testcase.java

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

rm -f *.class
rm -f output.txt

#Bonus Case for the brave
printf "Bonus: "
printf "%s " Pie.java

rm -f *.class
rm -f output.txt

# Check if the test case compiles
javac Pie.java 2> /dev/null
compile_value=$?
if [ $compile_value != 0 ]; then
	echo "Failed to Compile!"

else

	rm -f *.class

	# Check if the test case throws warning messages
	javac -Werror Pie.java -Xlint:unchecked 2> /dev/null
	compile_value=$?
	if [ $compile_value != 0 ]; then
		echo "Compiled with warnings!"
	else
		# Check if the test case crashes
		java Pie > output.txt 2> /dev/null
		runtime_value=$?
		if [ $runtime_value == 124 ]; then
			echo "Timeout"
		elif [ $runtime_value != 0 ]; then
			echo "Crashed!"
		else

			# Check if the output is correct
			diff output.txt sample_output/Pie.txt > /dev/null 2> /dev/null
			diff_value=$?
			if [ $diff_value != 0 ]; then
				echo "Wrong Answer!"
			else
				echo "PASS"
				((num_pass++))
			fi
		fi
	fi
fi

rm -f *.class
rm -f output.txt
