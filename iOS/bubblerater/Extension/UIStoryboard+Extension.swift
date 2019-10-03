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
}

extension UIStoryboard {
    
    static var main: UIStoryboard { return brStoryboard(name: BRStoryboardCategory.main) }
    
    private static func brStoryboard(name: String) -> UIStoryboard {
        
        return UIStoryboard(name: name, bundle: nil)
    }
}
