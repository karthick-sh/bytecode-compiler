package src.parser;

import src.argobj.*;

public interface Parser{
    ArgObj parse(String[] args);
}