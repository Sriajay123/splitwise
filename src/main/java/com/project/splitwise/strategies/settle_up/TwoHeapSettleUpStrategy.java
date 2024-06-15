package com.project.splitwise.strategies.settle_up;

import com.project.splitwise.models.Transaction;
import com.project.splitwise.models.User;
import org.aspectj.weaver.GeneratedReferenceTypeDelegate;
import org.springframework.data.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TwoHeapSettleUpStrategy implements SettleUpStrategy{


    @Override
    public List<Transaction> settleUp(Map<User, Double> userTotal) {
        PriorityQueue<Pair<User,Double>> maxHeap=new PriorityQueue<>((t1,t2)->(int) (t2.getSecond() - t1.getSecond()));
        PriorityQueue<Pair<User,Double>> minHeap=new PriorityQueue<>((t1,t2)->(int)(t1.getSecond()-t2.getSecond()));

        for (Map.Entry<User, Double> entry : userTotal.entrySet()) {
           if(entry.getValue()>0){
                maxHeap.add(Pair.of(entry.getKey(),entry.getValue()));
            }
            else{
                minHeap.add(Pair.of(entry.getKey(),entry.getValue()));
            }
        }


        return List.of();
    }
}
