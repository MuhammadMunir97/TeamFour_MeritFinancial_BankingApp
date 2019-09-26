/**
 * 
 */


(function($) {
	$(document).ready(function() {
		
		
		// Card Shuffle 
		function sortCards() {
			var cards = $('.account:not(.is-selected)', '.my-wallet-sidebar'),
				i = 0;
			
			$('.is-stationary').removeClass('is-stationary');
			
			cards.each(function(i) {
				var index = i;

				$(this).css({
					'top': (180 / (cards.length-1)) * index + 'px'
				});
				
				i++;
				
				if( cards.length === i || cards.length <= 2 ) {
					$(this).addClass('is-stationary');
				}
			});// END each
		}
		
		sortCards();
		
		// Card Shuffle Investments
		function sortCardsInv() {
			var cardsInv = $('.account-investments:not(.is-selected)', '.my-wallet-sidebar-investments'),
				i = 0;
			
			$('.is-stationary').removeClass('is-stationary');
			
			cardsInv.each(function(i) {
				var index = i;

				$(this).css({
					'top': (180 / (cardsInv.length-1)) * index + 'px'
				});
				
				i++;
				
				if( cardsInv.length === i || cardsInv.length <= 2 ) {
					$(this).addClass('is-stationary');
				}
			});// END each
		}
		
		sortCardsInv();
	
		// Set active account
		$(document).on('click','.my-wallet-sidebar .account:not(.is-selected)', function() {
			var card = $(this),
				account = $('[data-account="' + $(this).attr('data-account') +'"]'),
				selected = $('.is-selected'),
				placeholder = $('.transaction-history-placeholder');
			
			account.addClass('is-selected'); 
			placeholder.addClass('is-hidden');
			selected.removeClass('is-selected');
			setTimeout( sortCards, 10);
		});

		// Set active account investments
		$(document).on('click','.my-wallet-sidebar-investments .account-investments:not(.is-selected)', function() {
			var card = $(this),
				accountInv = $('[data-account="' + $(this).attr('data-account') +'"]'),
				selectedInv = $('.is-selected'),
				placeholderInv = $('.transaction-history-placeholder');
			
			accountInv.addClass('is-selected'); 
			placeholderInv.addClass('is-hidden');
			selectedInv.removeClass('is-selected');
			setTimeout( sortCardsInv, 10);
		});
		
			
		/* New Bootstrap Modal for accounts page */
		$('#myModal').on('shown.bs.modal', function () {
			$('#myInput').trigger('focus')
		});
				
		
		/* 
		var addAccountButton = $('.new-account button');
		
		addAccountButton.on('click', function() {
			addAccount();
			sortCards();
		});
		
		
		Close modal on overlay click
		$('.add-account-modal .overlay').on('click', function () {
			$('.add-account-modal').removeClass('is-visible');
		});
		
		*/
		
		
		
		
		
	});
})(jQuery);