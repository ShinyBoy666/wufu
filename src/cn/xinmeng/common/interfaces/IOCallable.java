package cn.xinmeng.common.interfaces;

public interface IOCallable<I,O> {
	O exec(I i);
}
