package com.mkyong.user;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.util.lang.Bytes;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.ValidationError;
import org.apache.wicket.validation.validator.AbstractValidator;

public class FileUploadPage extends WebPage {

	private FileUploadField fileUpload;
	private String UPLOAD_FOLDER = "C:\\";

	public FileUploadPage(final PageParameters parameters) {

		add(new FeedbackPanel("feedback"));

		Form<?> form = new Form<Void>("form") {
			@Override
			protected void onSubmit() {

				final FileUpload uploadedFile = fileUpload.getFileUpload();
				if (uploadedFile != null) {

					// write to a new file
					File newFile = new File(UPLOAD_FOLDER + uploadedFile.getClientFileName());

					if (newFile.exists()) {
						newFile.delete();
					}

					try {
						newFile.createNewFile();
						uploadedFile.writeTo(newFile);

						info("saved file: " + uploadedFile.getClientFileName());
					} catch (Exception e) {
						throw new IllegalStateException("Error");
					}
				}

			}

		};

		// Enable multipart mode (need for uploads file)
		form.setMultiPart(true);

		// max upload size, 10k
		form.setMaxSize(Bytes.megabytes(Double.valueOf("50")));

		// form.add(fileUpload = new FileUploadField("fileUpload"));

		form.add(fileUpload = new FileUploadField("fileUpload") {
			private static final long serialVersionUID = 1L;

			protected void convertInput() {
				setConvertedInput(getFileUpload());
			}
		});

		fileUpload.add(new AbstractValidator<FileUpload>() {
			private static final long serialVersionUID = 1L;

			protected void onValidate(IValidatable<FileUpload> validatable) {
				FileUpload fileUpload = validatable.getValue();
				String type = FilenameUtils.getExtension(fileUpload.getClientFileName());

				if (type.equals("csv"))
					showError(validatable, "CSV File uploaded");
				else
					showError(validatable, "Sorry, only CSV Files supported");

			}

			private void showError(IValidatable<FileUpload> validatable, String errorKey) {
				validatable.error(new ValidationError().setMessage(errorKey));
			}
		});

		add(form);

	}
	
	
}
