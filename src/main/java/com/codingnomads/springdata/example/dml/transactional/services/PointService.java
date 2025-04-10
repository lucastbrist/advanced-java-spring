/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.transactional.services;

import com.codingnomads.springdata.example.dml.transactional.models.Point;
import com.codingnomads.springdata.example.dml.transactional.repositories.PointRepo;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PointService {

    @Autowired
    PointRepo repo;

    // @Transactional I

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void doSomeWork() {
        Point p = new Point(1, 1);
        repo.save(p);

        p = new Point(2, 2);
        repo.save(p);

        /*
           In order to call the foo() method - we must have an existing transaction (MANDATORY)
        */
        foo();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void foo() {
        repo.getOne(1L);
    }

    // @Transactional II

    @Transactional(timeout = 5)
    public void savePoint() {
        // create new point (1,1)
        Point p = new Point(1, 1);

        // save new point
        repo.save(p);
    }

    @Transactional(timeout = 5)
    public void timeOutAfter5() {
        Point p = new Point(2, 2);
        repo.save(p);
    }

    @Transactional(timeout = 1)
    public void triggerTimeout() throws InterruptedException {
        Thread.sleep(950);
        Point p = new Point(1, 1);
        repo.save(p);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Point getPointById(Long id) {
        return repo.getOne(id);
    }

    @Transactional(readOnly = true)
    public void noExceptionExpected() {
        Point p = repo.getOne(1L);

        p.setX(5);

        repo.save(p);
    }

    @Transactional(rollbackFor = {IOException.class, ArithmeticException.class})
    public void rollbackFor() throws IOException, ArithmeticException {
        Point p = repo.getOne(1L);
        p.setX(100);
        p.setX(100);
        repo.save(p);
        throw new IOException();
        // no change to DB
    }

    @Transactional(noRollbackFor = InterruptedException.class)
    public void noRollbackFor() throws InterruptedException {
        Point p = repo.getOne(2L);
        p.setX(4);
        p.setX(20);
        repo.save(p);
        throw new InterruptedException();
        // changes still commit
    }

    @Transactional(timeout = 2)
    public void countTo3() {
        Thread thread = new Thread();
        try {
            thread.wait(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional(timeout = 1)
    public void instaTimeout() throws InterruptedException {
        Thread.sleep(1000);
        Point point = new Point(640000, 640000);
        repo.save(point);
    }
}
