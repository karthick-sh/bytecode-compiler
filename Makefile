# Makefile for ECE 30862 Fall 2019 Compiler Project

# Targets
compiler:
	@javac -d ./bin ./src/main/*.java ./src/argobj/*.java ./src/parser/*.java ./src/statement/*.java
	
clean:
	@rm -rf ./bin/*
	@touch ./bin/.gitignore

run:
	@java -cp ./bin/ src.main.Main $(inputfile)

test:
	@java -cp ./bin/ src.main.Main $(inputfile)
	@$(interpreter) $(basename $(inputfile)).smp
