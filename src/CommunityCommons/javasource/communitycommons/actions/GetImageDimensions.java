// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package communitycommons.actions;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import communitycommons.proxies.ImageDimensions;
import java.io.InputStream;

public class GetImageDimensions extends CustomJavaAction<IMendixObject>
{
	private IMendixObject __ImageParameter1;
	private system.proxies.Image ImageParameter1;

	public GetImageDimensions(IContext context, IMendixObject ImageParameter1)
	{
		super(context);
		this.__ImageParameter1 = ImageParameter1;
	}

	@Override
	public IMendixObject executeAction() throws Exception
	{
		this.ImageParameter1 = __ImageParameter1 == null ? null : system.proxies.Image.initialize(getContext(), __ImageParameter1);

		// BEGIN USER CODE
		ImageDimensions imageDimensions = new ImageDimensions(getContext());
		try (InputStream inputStream = Core.getImage(getContext(), this.ImageParameter1.getMendixObject(), false)) {
			BufferedImage bimg = ImageIO.read(inputStream);
			imageDimensions.setHeight(bimg.getHeight());
			imageDimensions.setWidth(bimg.getWidth());
		}

		return imageDimensions.getMendixObject();
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "GetImageDimensions";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
