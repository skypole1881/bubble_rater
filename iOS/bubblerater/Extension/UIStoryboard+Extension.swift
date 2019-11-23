//
//  UIStoryboard+Extension.swift
//  bubblerater
//
//  Created by lohsts on 2019/10/3.
//  Copyright © 2019 lohsts. All rights reserved.
//

import Foundation
import UIKit

struct BRStoryboardCategory {
    
    static let main = "Main"
    
    static let bubbleTea = "BubbleTea"
    
    static let auth = "Auth"
    
    static let news = "News"
    
    static let coupons = "Coupons"
}

extension UIStoryboard {
    
    static var main: UIStoryboard { return brStoryboard(name: BRStoryboardCategory.main) }
    
    static var bubbleTea: UIStoryboard { return brStoryboard(name: BRStoryboardCategory.bubbleTea) }
    
    static var auth: UIStoryboard { return brStoryboard(name: BRStoryboardCategory.auth) }
    
    static var news: UIStoryboard { return brStoryboard(name: BRStoryboardCategory.news) }
    
    static var coupons: UIStoryboard { return brStoryboard(name: BRStoryboardCategory.coupons) }
    
    private static func brStoryboard(name: String) -> UIStoryboard {
        
        return UIStoryboard(name: name, bundle: nil)
    }
}
