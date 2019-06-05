package com.wf.global;

import com.wf.entity.system.Auth;
import com.wf.entity.system.Function;
import com.wf.entity.system.Post;
import com.wf.entity.system.Staff;

import java.util.*;

public class FunctionTree {



    public static Map<Function,List<Function> > functionTree(List<Function> root,List<Function> other)
    {

        Collections.sort(other, new Comparator<Function>() {
            public int compare(Function o1, Function o2) {
                return o1.getSerialNum()-o2.getSerialNum();
            }
        });
        Map<Function,List<Function> > map=new HashMap<Function, List<Function>>();
        for(Function function:root)
        {
            List<Function> functions=new ArrayList<Function>();
            for(Function function1:other)
            {
                if(function.getId()==function1.getParentId())
                {
                    functions.add(function1);

                }
            }
            map.put(function,functions);
        }
        return map;
    }

    public static Map<Function,List<Function> > functionTree(Staff staff)
    {

        Map<Function,List<Function> > map=new HashMap<Function, List<Function>>();
        List<Function> root=new ArrayList<Function>();
        List<Function> other=new ArrayList<Function>();
        for(Post post:staff.getPost())
        {
            for(Auth auth:post.getDepartment().getAuth())
            {
                if (auth.getFunction().getAccordion()==0)
                {
                    root.add(auth.getFunction());

                }
                else
                {
                    other.add(auth.getFunction());

                }
            }
        }
        return functionTree(root,other);
    }
}
