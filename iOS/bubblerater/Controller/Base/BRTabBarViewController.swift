//
//  BRTabBarViewController.swift
//  bubblerater
//
//  Created by lohsts on 2019/10/3.
//  Copyright © 2019 lohsts. All rights reserved.
//

import UIKit

enum Tab: String {
    
    case bubbleTea = "珍奶"
    
    case news = "新聞"
    
    case coupons = "折價券"
    
    case auth = "設定"
    
    func brController() -> UIViewController {
        
        var controller: UIViewController
        
        switch self {
        case .bubbleTea:
            
            controller = UIStoryboard.bubbleTea.instantiateInitialViewController()!
        case .news:
            
            controller = UIStoryboard.news.instantiateInitialViewController()!
            
        case .coupons:
            
            controller = UIStoryboard.coupons.instantiateInitialViewController()!
            
        case .auth:
            
            controller = UIStoryboard.auth.instantiateInitialViewController()!
        }
        
        controller.tabBarItem = brTabBarItem()
        
        return controller
    }
    
    func brTabBarItem() -> UITabBarItem {
        
        switch self {
        case .bubbleTea:
            
            return UITabBarItem(
                title: self.rawValue,
                image: UIImage(),
                selectedImage: UIImage()
            )
        case .news:
            
            return UITabBarItem(
                title: self.rawValue,
                image: UIImage(),
                selectedImage: UIImage()
            )
        case .coupons:
            
            return UITabBarItem(
                title: self.rawValue,
                image: UIImage(),
                selectedImage: UIImage()
            )
        case .auth:
            
            return UITabBarItem(
                title: self.rawValue,
                image: UIImage(),
                selectedImage: UIImage()
            )
        }
    }
}

class BRTabBarViewController: UITabBarController, UITabBarControllerDelegate {
    
    private let tabs: [Tab] = [.bubbleTea, .news, .coupons, .auth]

    override func viewDidLoad() {
        super.viewDidLoad()
        
        viewControllers = tabs.map({ (tab) -> UIViewController in
            
            return tab.brController()
        })
        
        delegate = self
    }

    func tabBarController(_ tabBarController: UITabBarController, shouldSelect viewController: UIViewController) -> Bool {
        
        
        guard let navVC = viewController as? UINavigationController, let _ = navVC.viewControllers.first as? BubbleTeaViewController else { return true }
        
        return true
        // TODO
    }
}
