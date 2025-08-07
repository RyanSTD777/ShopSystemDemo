package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import model.ProductOrders;
import model.Users;
import service.impl.MemberServiceImpl;

public class Tools {
	
	public static void main(String[] args) {

	}
	
	public static void saveFile(Object object,String fileName)
	{
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Object readFile(String fileName)
	{
		Object object = null;
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			object=ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
	
	public static String getOrderDetailsText(ProductOrders pdorder, Users member) {
	    StringBuilder sb = new StringBuilder();
	    sb.append("　購物明細：\n");

	    int total = 0;

	    if (pdorder.getaChoy() > 0) {
	        sb.append("　A菜: ").append(pdorder.getaChoy()).append(" 公斤\n");
	        total += pdorder.getaChoy() * 105;
	    }
	    if (pdorder.getCarrot() > 0) {
	        sb.append("　胡蘿蔔: ").append(pdorder.getCarrot()).append(" 公斤\n");
	        total += pdorder.getCarrot() * 38;
	    }
	    if (pdorder.getChineseCelery() > 0) {
	        sb.append("　芹菜: ").append(pdorder.getChineseCelery()).append(" 公斤\n");
	        total += pdorder.getChineseCelery() * 47;
	    }
	    if (pdorder.getDaikonRadish() > 0) {
	        sb.append("　蘿蔔: ").append(pdorder.getDaikonRadish()).append(" 公斤\n");
	        total += pdorder.getDaikonRadish() * 35;
	    }
	    if (pdorder.getOnion() > 0) {
	        sb.append("　洋蔥: ").append(pdorder.getOnion()).append(" 公斤\n");
	        total += pdorder.getOnion() * 42;
	    }
	    if (pdorder.getSpoonCabbage() > 0) {
	        sb.append("　青江菜: ").append(pdorder.getSpoonCabbage()).append(" 公斤\n");
	        total += pdorder.getSpoonCabbage() * 94;
	    }
	    if (pdorder.getSugarSnapPea() > 0) {
	        sb.append("　甜豆: ").append(pdorder.getSugarSnapPea()).append(" 公斤\n");
	        total += pdorder.getSugarSnapPea() * 117;
	    }
	    if (pdorder.getWaterSpinach() > 0) {
	        sb.append("　空心菜: ").append(pdorder.getWaterSpinach()).append(" 公斤\n");
	        total += pdorder.getWaterSpinach() * 134;
	    }
	    if (pdorder.getWelshOnion() > 0) {
	        sb.append("　青蔥: ").append(pdorder.getWelshOnion()).append(" 公斤\n");
	        total += pdorder.getWelshOnion() * 152;
	    }

	    sb.append("　------------------------\n");

	    String level = member.getMemberLevel();
	    double discountRate = 1.0;

	    switch (level) {
	        case "金會員":
	            discountRate = 0.85;
	            break;
	        case "銀會員":
	            discountRate = 0.90;
	            break;
	        case "銅會員":
	            discountRate = 0.95;
	            break;
	        default:
	            discountRate = 1.0;
	    }

	    int finalPrice = (int) Math.round(total * discountRate);

	    if (discountRate < 1.0) {
	        sb.append("　原價: ").append(total).append(" 元\n");
	        sb.append("　").append(level).append("優惠價: ").append(finalPrice).append(" 元");
	    } else {
	        sb.append("　共: ").append(total).append(" 元");
	    }

	    return sb.toString();
	}
	
	public static String getOrderReportText(Users member, ProductOrders pdorder) {
	    StringBuilder sb = new StringBuilder();

	    sb.append("　客戶資料：\n")
	      .append("　客戶名: ").append(member.getName()).append("\n")
	      .append("　會員等級: ").append(member.getMemberLevel()).append("\n")
	      .append("　電話: ").append(member.getPhone()).append("\n\n")
	      .append("　購物明細：\n");

	    int total = 0;

	    if (pdorder.getaChoy() > 0) {
	        sb.append("　A菜: ").append(pdorder.getaChoy()).append(" 公斤\n");
	        total += pdorder.getaChoy() * 105;
	    }
	    if (pdorder.getCarrot() > 0) {
	        sb.append("　胡蘿蔔: ").append(pdorder.getCarrot()).append(" 公斤\n");
	        total += pdorder.getCarrot() * 38;
	    }
	    if (pdorder.getChineseCelery() > 0) {
	        sb.append("　芹菜: ").append(pdorder.getChineseCelery()).append(" 公斤\n");
	        total += pdorder.getChineseCelery() * 47;
	    }
	    if (pdorder.getDaikonRadish() > 0) {
	        sb.append("　蘿蔔: ").append(pdorder.getDaikonRadish()).append(" 公斤\n");
	        total += pdorder.getDaikonRadish() * 35;
	    }
	    if (pdorder.getOnion() > 0) {
	        sb.append("　洋蔥: ").append(pdorder.getOnion()).append(" 公斤\n");
	        total += pdorder.getOnion() * 42;
	    }
	    if (pdorder.getSpoonCabbage() > 0) {
	        sb.append("　青江菜: ").append(pdorder.getSpoonCabbage()).append(" 公斤\n");
	        total += pdorder.getSpoonCabbage() * 94;
	    }
	    if (pdorder.getSugarSnapPea() > 0) {
	        sb.append("　甜豆: ").append(pdorder.getSugarSnapPea()).append(" 公斤\n");
	        total += pdorder.getSugarSnapPea() * 117;
	    }
	    if (pdorder.getWaterSpinach() > 0) {
	        sb.append("　空心菜: ").append(pdorder.getWaterSpinach()).append(" 公斤\n");
	        total += pdorder.getWaterSpinach() * 134;
	    }
	    if (pdorder.getWelshOnion() > 0) {
	        sb.append("　青蔥: ").append(pdorder.getWelshOnion()).append(" 公斤\n");
	        total += pdorder.getWelshOnion() * 152;
	    }

	    sb.append("　------------------------\n");

	    String level = member.getMemberLevel();
	    double discountRate = 1.0;

	    switch (level) {
	        case "金會員":
	            discountRate = 0.85;
	            break;
	        case "銀會員":
	            discountRate = 0.90;
	            break;
	        case "銅會員":
	            discountRate = 0.95;
	            break;
	        default:
	            discountRate = 1.0;
	    }

	    int finalTotal = (int) Math.round(total * discountRate);

	    if (discountRate < 1.0) {
	        sb.append("　原價: ").append(total).append(" 元\n")
	          .append("　").append(level).append("優惠後: ").append(finalTotal).append(" 元");
	    } else {
	        sb.append("　總計: ").append(total).append(" 元");
	    }

	    return sb.toString();
	}
	
	public static String formatOrderList(List<ProductOrders> orders) {
	    StringBuilder sb = new StringBuilder();
	    int[] grandTotal = {0};
	    MemberServiceImpl msi = new MemberServiceImpl();
	    int[] count = {0};

	    orders.stream()
	        .filter(p -> getSubtotal(p) > 0)
	        .forEach(p -> {
	            StringBuilder orderDetail = new StringBuilder();
	            int subtotal = 0;

	            if (p.getaChoy() > 0) {
	                orderDetail.append("A菜 ").append(p.getaChoy()).append(" 公斤，");
	                subtotal += p.getaChoy() * 105;
	            }
	            if (p.getCarrot() > 0) {
	                orderDetail.append("胡蘿蔔 ").append(p.getCarrot()).append(" 公斤，");
	                subtotal += p.getCarrot() * 38;
	            }
	            if (p.getChineseCelery() > 0) {
	                orderDetail.append("芹菜 ").append(p.getChineseCelery()).append(" 公斤，");
	                subtotal += p.getChineseCelery() * 47;
	            }
	            if (p.getDaikonRadish() > 0) {
	                orderDetail.append("白蘿蔔 ").append(p.getDaikonRadish()).append(" 公斤，");
	                subtotal += p.getDaikonRadish() * 35;
	            }
	            if (p.getOnion() > 0) {
	                orderDetail.append("洋蔥 ").append(p.getOnion()).append(" 公斤，");
	                subtotal += p.getOnion() * 42;
	            }
	            if (p.getSpoonCabbage() > 0) {
	                orderDetail.append("青江菜 ").append(p.getSpoonCabbage()).append(" 公斤，");
	                subtotal += p.getSpoonCabbage() * 94;
	            }
	            if (p.getSugarSnapPea() > 0) {
	                orderDetail.append("甜豆 ").append(p.getSugarSnapPea()).append(" 公斤，");
	                subtotal += p.getSugarSnapPea() * 117;
	            }
	            if (p.getWaterSpinach() > 0) {
	                orderDetail.append("空心菜 ").append(p.getWaterSpinach()).append(" 公斤，");
	                subtotal += p.getWaterSpinach() * 134;
	            }
	            if (p.getWelshOnion() > 0) {
	                orderDetail.append("青蔥 ").append(p.getWelshOnion()).append(" 公斤，");
	                subtotal += p.getWelshOnion() * 152;
	            }

	            if (orderDetail.length() > 0 && orderDetail.charAt(orderDetail.length() - 1) == '，') {
	                orderDetail.deleteCharAt(orderDetail.length() - 1);
	            }

	            Users member = Optional.ofNullable(msi.findByName(p.getName())).orElse(new Users());
	            String level = Optional.ofNullable(member.getMemberLevel()).orElse("非會員");

	            double discountRate;
	            switch (level) {
	                case "金會員":
	                    discountRate = 0.85;
	                    break;
	                case "銀會員":
	                    discountRate = 0.90;
	                    break;
	                case "銅會員":
	                    discountRate = 0.95;
	                    break;
	                default:
	                    discountRate = 1.0;
	            }
	            int discountedSubtotal = (int) Math.round(subtotal * discountRate);

	            sb.append("訂單編號： ").append(p.getId())
	              .append("\n購買人： ").append(p.getName())
	              .append("\n會員等級： ").append(level)
	              .append("\n購買明細： ").append(orderDetail)
	              .append("\n小計：").append(subtotal).append(" 元");
	            if (discountRate < 1.0) {
	                sb.append("（優惠後 ").append(discountedSubtotal).append(" 元）");
	            }
	            sb.append("\n\n");

	            grandTotal[0] += discountedSubtotal;
	            count[0]++;
	        });

	    sb.append("總計： ").append(count[0]).append(" 筆訂單，總金額： ").append(grandTotal[0]).append(" 元");

	    return sb.toString();
	}

	private static int getSubtotal(ProductOrders p) {
	    return p.getaChoy() * 105 +
	           p.getCarrot() * 38 +
	           p.getChineseCelery() * 47 +
	           p.getDaikonRadish() * 35 +
	           p.getOnion() * 42 +
	           p.getSpoonCabbage() * 94 +
	           p.getSugarSnapPea() * 117 +
	           p.getWaterSpinach() * 134 +
	           p.getWelshOnion() * 152;
	}
}
