
			old = gist_string(deque);
			try {
				deque.removeLast();
				comp.removeLast();
				if (!edge_check(comp, deque)) {
					System.out.println(message(old+".removeLast()", gist_string(comp), gist_string(deque)));
					break;
				}
				if (comp.size() != deque.size()) {
					System.out.println(message(old+".removeLast()\n"+gist_string(deque)+".size()", comp.size(), deque.size()));
					break;
				}
			} catch (Exception e) {
				System.out.println(message(old+".removeLast()", gist_string(comp), e.toString()));
				break;
			}
		}

		System.out.println("adding backward to meet at middle");

		for (int i = 0; i < 1000; i++) {
			String old = gist_string(deque);
			try {
				deque.addFirst(i);
				comp.addFirst(i);
				if (!edge_check(comp, deque)) {
					System.out.println(message(old+".addFirst("+i+")", gist_string(comp), gist_string(deque)));
					break;
				}
				if (comp.size() != deque.size()) {
					System.out.println(message(old+".addFirst("+i+")\n"+gist_string(deque)+".size()", comp.size(), deque.size()));
					break;
				}
			} catch (Exception e) {
				System.out.println(message(old+".addFirst("+i+")", gist_string(comp), e.toString()));
				break;
			}
		}

		System.out.println("removing from front with wrap");

		for (int i = 0; i < 1000; i++) {
			String old = gist_string(deque);
			try {
				deque.removeFirst();
				comp.removeFirst();
				if (!edge_check(comp, deque)) {
					System.out.println(message(old+".removeFirst()", gist_string(comp), gist_string(deque)));
					break;
				}
				if (comp.size() != deque.size()) {
					System.out.println(message(old+".removeFirst()\n"+gist_string(deque)+".size()", comp.size(), deque.size()));
					break;
				}
			} catch (Exception e) {
				System.out.println(message(old+".removeFirst()", gist_string(comp), e.toString()));
				break;
			}
		}
	}
}
