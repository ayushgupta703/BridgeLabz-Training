package scenario_based;

import java.util.Stack;

class Page {
	String url;
	String title;
	
	public Page(String url, String title) {
		this.url = url;
		this.title = title;
	}
	
	@Override
	public String toString() {
		return title + " on " + url;
	}
}

class HistoryNode {
	Page url;
	HistoryNode next;
	HistoryNode prev;
	
	public HistoryNode(Page page) {
		this.url = page;
		this.next = null;
		this.prev = null;
	}
}

public class BrowserBuddy {
	HistoryNode head, current;
	Stack<Page> closedTab;
	
	public BrowserBuddy() {
		this.head = null;
		this.current = null;
		closedTab = new Stack<Page>();
	}
	
	public void openPage(Page page) {
		HistoryNode newNode = new HistoryNode(page);
		if (current == null) {
			head = newNode;
			current = newNode;
		} else {
			if (current.next != null) {
				current.next.prev = null;
				current.next = null;
			}
			current.next = newNode;
			newNode.prev = current;
			current = newNode;
		}
		System.out.println("New Page " + page.toString() + " Opened");
	}
	
	public void goBack() {
		if (current == null || current.prev == null) {
			System.out.println("No Previous History Found!!");
			return;
		} else {
			current = current.prev;
			System.out.println("Moved To Previous Page!!");
		}
	}
	
	public void goForward() {
		if (current == null || current.next == null) {
			System.out.println("No Next Page Found!!");
			return;
		} else {
			current = current.next;
			System.out.println("Moved To Next Page!!");
		}
	}
	
	public void closeTab() {
		if (current == null) {
			System.out.println("No Tabs To Close");
			return;
		} else {
			Page closedPage = closedTab.push(current.url);
			head = null;
			current = null;
			System.out.println(closedPage.title + " Tab Closed ");			
		}
	}
	
	public void restoreTab() {
		if (closedTab.empty()) {
			System.out.println("No Tabs Closed Recently!!");
		} else {
			Page restoredPage = closedTab.pop();
			HistoryNode newNode = new HistoryNode(restoredPage);
			head = newNode;
			current = newNode;
			System.out.println(restoredPage.title + " Tab Restored ");
		}
	}
	
	public static void main(String[] args) {

	    BrowserBuddy browser = new BrowserBuddy();

	    Page google = new Page("https://google.com", "Google");
	    Page youtube = new Page("https://youtube.com", "YouTube");
	    Page gmail = new Page("https://mail.google.com", "Gmail");
	    Page github = new Page("https://github.com", "GitHub");

	    browser.openPage(google);
	    browser.openPage(youtube);
	    browser.openPage(gmail);
	    browser.goBack();
	    browser.goBack();
	    browser.goForward();
	    browser.openPage(github);
	    browser.closeTab();
	    browser.restoreTab();
	    browser.goBack();
	}

}
