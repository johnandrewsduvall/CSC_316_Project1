function test {
    local INPUT_FILEPATH='../testdata/testinput1.txt';
    local OUTPUT_FILEPATH='../testdata/testoutput1.txt';
    local EXCPECTED_OUTPUT_FILE_PATH='../testdata/expectedoutput1.txt';

    echo 'Cleaning up';
    cd ../testdata;
    rm -f testoutput.txt;
    cd ../src/csc_316_project1;
    rm -f *.class;

    echo 'Building code';
    javac *.java;

    if [ -f Receiver.class ]
        then
            echo 'Code built';
            cd ../;
            echo 'Running code against testinput1.txt';
            java csc_316_project1.Receiver $INPUT_FILEPATH $OUTPUT_FILEPATH;
            if [ -f $EXCPECTED_OUTPUT_FILE_PATH ]
                then
                    echo 'Code ran, generating output file ' $OUTPUT_FILEPATH;
                    echo 'Comparing testoutput1.txt to expectedoutput1.txt. Here are the changes (if any):';
                    diff $EXCPECTED_OUTPUT_FILE_PATH $OUTPUT_FILEPATH;
            fi
    fi

    echo 'Done';
}

test

