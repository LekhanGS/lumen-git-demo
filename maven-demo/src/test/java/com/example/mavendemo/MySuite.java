package com.example.mavendemo;
import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Customer Suite")
@SelectPackages("com.example.mavendemo.foo")
public class MySuite {
}
