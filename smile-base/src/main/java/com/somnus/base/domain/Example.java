package com.somnus.base.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Example extends Base {
	private BigDecimal value;

	private BigDecimal value2;

	private BigDecimal value3;

	public Example() {
		this.value = BigDecimal.ZERO;
		this.value2 = BigDecimal.ZERO;
		this.value3 = BigDecimal.ZERO;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue2() {
		return value2;
	}

	public void setValue2(BigDecimal value2) {
		this.value2 = value2;
	}

	public BigDecimal getValue3() {
		return value3;
	}

	public void setValue3(BigDecimal value3) {
		this.value3 = value3;
	}

	/**
	 * 将单位转化成万，保留6位小数
	 * 
	 * @author user
	 *
	 */
	public Wan getWan() {
		return new Wan();
	}

	public class Wan {
		private final BigDecimal base = new BigDecimal("10000");
		private final int num = 6;

		public BigDecimal getValue() {
			return value == null ? new BigDecimal(0) : value.divide(base, num,
					RoundingMode.CEILING);
		}

		public BigDecimal getValue2() {
			return value2 == null ? new BigDecimal(0) : value2.divide(base,
					num, RoundingMode.CEILING);
		}

		public BigDecimal getValue3() {
			return value3 == null ? new BigDecimal(0) : value3.divide(base,
					num, RoundingMode.CEILING);
		}
	}
}
