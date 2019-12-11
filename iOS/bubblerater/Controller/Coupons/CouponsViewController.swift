//
//  CouponsViewController.swift
//  bubblerater
//
//  Created by Agnes Lo on 2019/11/23.
//  Copyright © 2019 lohsts. All rights reserved.
//

import UIKit

class CouponTableViewCell: UITableViewCell {
    @IBOutlet weak var storename: UILabel!
    
}
class CouponsViewController: BRBaseViewController, UITableViewDataSource, UITableViewDelegate {
    @IBOutlet weak var coupontable: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        coupontable.dataSource = self
        coupontable.delegate = self
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 10
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "couponcell", for: indexPath) as! CouponTableViewCell
        cell.storename.text = "飲川"
        return cell
    }
}
