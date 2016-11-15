/**
 * PrimeFaces AutoComplete Widget
 */
PrimeFaces.widget.AutoComplete = PrimeFaces.widget.AutoComplete.extend ( {

	bindKeyEvents: function() {
		var $this = this;

		if(!this.cfg.active && this.cfg.multiple){
			this.input.on('keydown.autoComplete', function(e) {
	            var keyCode = $.ui.keyCode;
	            key = e.which;

	            switch(e.which) {
                    case keyCode.TAB:
                    	if($this.input.val().length){
                        	$this.invokeItemSelectBehavior(event, $this.input.val());
                            e.preventDefault();
                        }
                    break;
                    
                    case keyCode.ENTER:
                    case keyCode.NUMPAD_ENTER:
                        if($this.input.val().length){
                        	$this.invokeItemSelectBehavior(event, $this.input.val());
                        }
                        e.preventDefault();                        
                    break;
                    
                    case keyCode.BACKSPACE:
                        if (!$this.input.val().length) {
                            $this.removeItem(e, $(this).parent().prev());
                            e.preventDefault();
                        }
                    break;
                };
			});
		}else{
			this._super();
    	}
	}
});