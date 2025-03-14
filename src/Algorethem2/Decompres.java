package Algorethem2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import application.Stack_Linked_list;
import application.TNode;

public class Decompres {

	String name;
	File filePath;
	String decpath;

	public void decompress() throws IOException {
		File f1 =filePath;
		FileInputStream f2 = new FileInputStream(f1);
		int n = 0;
		int counter = 0;

		n = f2.read();
		String name = "";
		for (int i = 0; i < n; i++) {
			name += (char) f2.read();
		}

	//	System.out.println(name);
		
		byte[] buffer = new byte[8];

		
		ArrayList<Byte> newn = new ArrayList<>();

		
		String sum = "";

		
		n = f2.read(buffer);

		
		int k = 0;
		for (int i = 0; i < n; i++) {
			sum += (char) buffer[i];
		}
		while ((n = f2.read()) != -1) {
			char ch = sum.charAt(0);
			sum = sum.substring(1);
			sum += (char) (n);
			newn.add((byte) ch);
			if (sum.compareTo("end line") == 0) {
				break;
			}
		}

		ArrayList<Byte> tree = new ArrayList<>();
		int counttree = 0;

//		for (int i = 0; i < newn.size() - 1; i++) {
//			System.out.print(newn.get(i) + "   ");
//		}
		
		
		System.out.println();

		for (int i = 0; i < newn.size() - 1;) {
			for (int j = 0; j < 8;) {
				// System.out.println("j= "+j);

				byte ones = (byte) ((1) & (newn.get(i) >> (7 - j)));
				// System.out.println(ones+ " top " +i);
				counttree++;
				if (counttree % 8 == 0) {
					i++;
					counttree = 0;
				}

				if (ones == 0) {
					j++;
					//System.out.println(ones);
					tree.add(ones);
				} else if (ones == 1) {
					//System.out.println(ones);
					tree.add(ones);
					j++;
					if (j == 8) {
						j = 0;
					}
					int counte = 0;
					int nu = 0;
					while (counte < 8) {
						// System.out.println(counte +" "+j+" opp");
						ones = (byte) ((1) & (newn.get(i) >> (7 - j)));
						// System.out.println(ones+" down "+ i);
						counttree++;
						if (counttree % 8 == 0) {
							counttree = 0;
							i++;
						}
						nu += Math.pow(2, 7 - counte) * ones;
						j++;
						if (j == 8) {
							j = 0;
						}
						counte++;
					}
					System.out.println(nu);
					tree.add((byte) nu);
				}

			}

		}

		for (int i = 0; i < newn.get(newn.size() - 1); i++) {

			tree.remove(tree.size() - 1);
		}

		System.out.println();
		System.out.println();
		
//		for (int i = 0; i < tree.size(); i++) {
//			System.out.print(tree.get(i) + "   ");
//		}
		
		
		System.out.println();
		byte[] lastbyts = new byte[100];
		TNode<Byte> root = buildTree(tree);
		//preTraverc(root, "");
		System.out.println();
		File fileout =new File(decpath+"//"+name);
	
		
		// new File(decpath+"//"+name);
		// C:\\Users\\HP\\Downloads\\Screene.png
		// "C:\Users\HP\Videos\2024-08-26 22-20-58.mkv"
		FileOutputStream fos = new FileOutputStream(fileout);

		byte[] bufferout = new byte[16];

		buffer = new byte[16];

		counter = 0;

		TNode<Byte> curr = root;

		int count = 0;

		byte last = 0;

		byte[] buffer1 = new byte[16];
		int n1 = f2.read(buffer);
		int coun = 0;
		n = f2.read(buffer1);
		boolean loop = true;
		while (loop) {
			if (n < 16) {
				//System.out.println(n1 + "   " + n);
				lastbyts = new byte[(n1) * 16];
				if (n == -1) {
					last = (byte) (7 - buffer[n1 - 1]);
					n1 = n1 - 1;
				} else {

					last = (byte) (7 - buffer1[n - 1]);

				}
				for (int i = 0; i < n1; i++) {
					for (int j = 0; j < 8; j++) {
						byte ones = (byte) ((1) & (buffer[i] >> (7 - j)));
						if (ones == 1 && curr.getRigth() != null) {
							curr = curr.getRigth();
						} else if (ones == 0 && curr.getLeft() != null) {
							curr = curr.getLeft();
						}
						if (curr.isleaf()) {
							//System.out.println(curr.getData() + " too");
							lastbyts[coun] = curr.getData();
							coun++;
							curr = root;
						}
					}
				}
				for (int i = 0; i < n - 1; i++) {
					for (int j = 0; j < 8; j++) {
						byte ones = (byte) ((1) & (buffer1[i] >> (7 - j)));
						if (ones == 1 && curr.getRigth() != null) {
							curr = curr.getRigth();
						} else if (ones == 0 && curr.getLeft() != null) {
							curr = curr.getLeft();
						}
						if (curr.isleaf()) {
							//System.out.println(curr.getData() + "  to");
							lastbyts[coun] = curr.getData();
							coun++;
							curr = root;
						}

					}
				}
				loop = false;
			} else {
				for (int i = 0; i < n1; i++) {
					for (int j = 0; j < 8; j++) {
						byte ones = (byte) ((1) & (buffer[i] >> (7 - j)));
						if (ones == 1 && curr.getRigth() != null) {
							curr = curr.getRigth();
						} else if (ones == 0 && curr.getLeft() != null) {
							curr = curr.getLeft();
						}
						if (curr.isleaf()) {
							// System.out.println(curr.getData()+" frommm");
							bufferout[counter] = curr.getData();
							count++;
							counter++;
							curr = root;
						}

						if (counter == 16) {
							counter = 0;
							fos.write(bufferout);
							count = 0;
							bufferout = new byte[16];

						}

					}

				}
			}
			n1 = n;

			buffer = buffer1.clone();
			n = f2.read(buffer1);

		}

		// System.out.println(last);
		curr = root;
		for (int i = 0; i <= last; i++) {
			curr = curr.getLeft();
			if (curr.isleaf()) {
				coun--;
				curr = root;
			}

		}
		for (int i = 0; i < count; i++) {

			fos.write(bufferout[i]);
		}
		for (int i = 0; i < coun; i++) {
			fos.write(lastbyts[i]);
		}

		fos.close();

	}

	public static void main(String[] args) throws IOException {
	}

	public  TNode<Byte> buildTree(ArrayList<Byte> preCode) {
		Stack<TNode> stack = new Stack<>();
		TNode<Byte> root = null;

		for (int i = 0; i < preCode.size(); i++) {
			if (preCode.get(i) == 1) {
				i++;
				if (i >= preCode.size()) {
					throw new IllegalArgumentException("out of size tree");
				}

				TNode<Byte> leaf = new TNode(preCode.get(i));

				if (stack.isEmpty()) {
					root = leaf;
				} else {
					while (!stack.isEmpty() && stack.peek().getLeft() != null && stack.peek().getRigth() != null) {
						stack.pop();
					}
					if (!stack.isEmpty()) {
						TNode<Byte> parent = stack.peek();
						if (parent.getLeft() == null) {
							parent.setLeft(leaf);
						} else {
							parent.setRigth(leaf);
						}
					}
				}
			} else if (preCode.get(i) == 0) {
				TNode<Byte> internalNode = new TNode();
				if (stack.isEmpty()) {
					root = internalNode;
				} else {
					while (!stack.isEmpty() && stack.peek().getLeft() != null && stack.peek().getRigth() != null) {
						stack.pop();
					}
					if (!stack.isEmpty()) {
						TNode<Byte> parent = stack.peek();
						if (parent.getLeft() == null) {
							parent.setLeft(internalNode);
						} else {
							parent.setRigth(internalNode);
						}
					}
				}
				stack.push(internalNode);
			} else {
				throw new IllegalArgumentException("Invalid input: only 0 and 1 are allowed.");
			}
		}

		return root;
	}

	public  void preTraverc(TNode<Byte> newn, String n) {

		if (newn == null) {
			return;
		}

		if (newn.getLeft() != null) {
			preTraverc(newn.getLeft(), n + "0");
		}
		if (newn.isleaf()) {
			System.out.println(newn.getData() + "   " + n);
		}
		if (newn.getRigth() != null) {
			preTraverc(newn.getRigth(), n + "1");
		}

	}

}


































//public TNode<Byte> buildTree(ArrayList<Byte> postCode) {
//    Stack<TNode<Byte>> stack = new Stack<>();
//    TNode<Byte> root = null;
//
//    for (int i = postCode.size() - 1; i >= 0; i--) { 
//        if (postCode.get(i) == 1) {
//            i--;
//            if (i < 0) {
//                throw new IllegalArgumentException("Size not valid");
//            }
//
//            TNode<Byte> leaf = new TNode<>(postCode.get(i));
//
//            if (stack.isEmpty()) {
//                root = leaf;
//            } else {
//                TNode<Byte> parent = stack.peek();
//                if (parent.getRigth() == null) {
//                    parent.setRigth(leaf);
//                } else {
//                    parent.setLeft(leaf);
//                    stack.pop();
//                }
//            }
//        } else if (postCode.get(i) == 0) {
//            TNode<Byte> internalNode = new TNode<>();
//
//            if (stack.isEmpty()) {
//                root = internalNode;
//            } else {
//                TNode<Byte> parent = stack.peek();
//                if (parent.getRigth() == null) {
//                    parent.setRigth(internalNode);
//                } else {
//                    parent.setLeft(internalNode);
//                    stack.pop();
//                }
//            }
//            stack.push(internalNode);
//        } else {
//            throw new IllegalArgumentException("Invalid input: only 0 and 1 are allowed.");
//        }
//    }
//
//    return root;
//}

