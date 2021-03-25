package org.pojoC;

public class PageObjectMana {
	private static PageObjectMana pageObjectMana;
	private HotelPojo1st hotelPojo1st;
	private HotelPojo2nd hotelPojo2nd;
	private HotelPojo3rd hotelPojo3rd;
	private HotelPojo4th hotelPojo4th;
	private HotelPojo5th hotelPojo5th;

	public static PageObjectMana getPageObjectMana() {
		return (pageObjectMana == null) ? pageObjectMana = new PageObjectMana() : pageObjectMana;

	}

	public HotelPojo1st getHotelPojo1st() {
		return (hotelPojo1st == null) ? hotelPojo1st = new HotelPojo1st() : hotelPojo1st;

	}

	public HotelPojo2nd getHotelPojo2nd() {
		return (hotelPojo2nd == null) ? hotelPojo2nd = new HotelPojo2nd() : hotelPojo2nd;

	}

	public HotelPojo3rd getHotelPojo3rd() {
		return (hotelPojo3rd == null) ? hotelPojo3rd = new HotelPojo3rd() : hotelPojo3rd;

	}

	public HotelPojo4th getHotelPojo4th() {
		return (hotelPojo3rd == null) ? hotelPojo4th = new HotelPojo4th() : hotelPojo4th;

	}

	public HotelPojo5th getHotelPojo5th() {
		return (hotelPojo5th == null) ? hotelPojo5th = new HotelPojo5th() : hotelPojo5th;

	}

}
