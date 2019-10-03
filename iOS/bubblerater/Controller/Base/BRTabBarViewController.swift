//
//  BRTabBarViewController.swift
//  bubblerater
//
//  Created by lohsts on 2019/10/3.
//  Copyright © 2019 lohsts. All rights reserved.
//

import UIKit

enum Tab: String {
    
    case tab1 = "tab1"
    
    case tab2
    
    case tab3
    
    func brController() -> UIViewController {
        
        var controller: UIViewController
        
        switch self {
        case .tab1:
            
            controller = UIStoryboard.main.instantiateInitialViewController()!
        case .tab2:
            
            controller = UIStoryboard.main.instantiateInitialViewController()!
            
        case .tab3:
            
            controller = UIStoryboard.main.instantiateInitialViewController()!
        }
        
        controller.tabBarItem = brTabBarItem()
        
        return controller
    }
    
    func brTabBarItem() -> UITabBarItem {
        
        switch self {
        case .tab1:
            
            return UITabBarItem(
                title: "tab1",
                image: UIImage(),
                selectedImage: UIImage()
            )
        case .tab2:
            
            return UITabBarItem(
                title: "tab1",
                image: UIImage(),
                selectedImage: UIImage()
            )
        case .tab3:
            
            return UITabBarItem(
                title: "tab1",
                image: UIImage(),
                selectedImage: UIImage()
            )
        }
    }
}

class BRTabBarViewController: UITabBarController, UITabBarControllerDelegate {
    
    private let tabs: [Tab] = [.tab1, .tab2, .tab3]

    override func viewDidLoad() {
        super.viewDidLoad()
        
        viewControllers = tabs.map({ (tab) -> UIViewController in
            
            return tab.brController()
        })
        
        delegate = self
    }

    func tabBarController(_ tabBarController: UITabBarController, shouldSelect viewController: UIViewController) -> Bool {
        
        // TODO
    }
}
