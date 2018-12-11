package VO;

import VO.Emp;
import VO.BeanUtil;

public class EmpAction {
    Emp emp = new Emp();

    public void setValue(String value) throws Exception {
        BeanUtil.setBeanValue(this, value);
    }

    public Emp getEmp() {
        return emp;
    }
}
