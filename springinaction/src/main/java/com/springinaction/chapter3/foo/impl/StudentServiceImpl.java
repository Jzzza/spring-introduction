package com.springinaction.chapter3.foo.impl;

import com.springinaction.chapter3.foo.Course;
import com.springinaction.chapter3.foo.CourseFullEvent;
import com.springinaction.chapter3.foo.Student;
import com.springinaction.chapter3.foo.StudentService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class StudentServiceImpl implements StudentService, ApplicationContextAware {
    private ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = context;
    }

    public void enrollStudentInCourse(Course course, Student student) {
        context.publishEvent(new CourseFullEvent(this, course));
    }
}
